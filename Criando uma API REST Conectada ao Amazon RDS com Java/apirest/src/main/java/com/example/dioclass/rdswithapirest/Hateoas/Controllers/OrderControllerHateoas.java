package com.example.dioclass.rdswithapirest.Hateoas.Controllers;

import com.example.dioclass.rdswithapirest.Hateoas.Entitys.OrderHateoas;
import com.example.dioclass.rdswithapirest.Hateoas.Entitys.Status;
import com.example.dioclass.rdswithapirest.Hateoas.Exceptions.OrderNotFoundExceptionHateoas;
import com.example.dioclass.rdswithapirest.Hateoas.Repositories.OrderRepositoryHateoas;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class OrderControllerHateoas {

    //definindo o repository
    private final OrderRepositoryHateoas repositoryOrder;

    public OrderControllerHateoas(OrderRepositoryHateoas repositoryHateoas) {
        this.repositoryOrder = repositoryHateoas;
    }

    @GetMapping("/orders")
    ResponseEntity<List<OrderHateoas>> consultOrderAll() {
        Long idOrder;
        List<OrderHateoas> orderList = repositoryOrder.findAll();

        // checar se a lista esta vazia
        if (orderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for (OrderHateoas orderHateoas : orderList) {
            idOrder = orderHateoas.getId();
            Link linkUri;
            // linkto cria a uri. e methodoOn associa
            linkUri = linkTo(methodOn(OrderControllerHateoas.class).consultOneOrder(idOrder)).withSelfRel();
            orderHateoas.add(linkUri);
            linkUri = linkTo(methodOn(OrderControllerHateoas.class).consultOrderAll()).withRel("Lista de pedidos de clientes");
            orderHateoas.add(linkUri);
        }
        return new ResponseEntity<List<OrderHateoas>> (orderList, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    ResponseEntity<OrderHateoas> consultOneOrder(@PathVariable Long id) {
        Optional<OrderHateoas> orderPointer = repositoryOrder.findById(id);
        if (orderPointer.isPresent()) {
            OrderHateoas order = orderPointer.get();
            order.add(linkTo(methodOn(OrderControllerHateoas.class).consultOrderAll()).withRel("All orders"));
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //adicionando um employee
    @PostMapping("/orders")
    OrderHateoas newOrder(@RequestBody OrderHateoas newOrder) {
        return repositoryOrder.save(newOrder);
    }

    //modificação parcial
    @PutMapping("/orders/{id}")
    OrderHateoas replaceOrder(@RequestBody OrderHateoas newOrder, long id) {
        return repositoryOrder.findById(id).map(order -> {
            order.setDescription(newOrder.getDescription());
            order.setStatus(newOrder.getStatus());
            return repositoryOrder.save(newOrder);
        }).orElseGet(() -> {
            newOrder.setId(id);
            return repositoryOrder.save(newOrder);
        });
    }

    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable long id) {
        repositoryOrder.deleteById(id);
    }

    @PutMapping("/orders/{id}/cancel")
    public ResponseEntity<?> cancelOrderById(@PathVariable Long id) {
        OrderHateoas cancelledOrder = repositoryOrder.findById(id).orElseThrow(() -> new OrderNotFoundExceptionHateoas(id));

        // testar se o status esta em progresso
        if (cancelledOrder.getStatus() == Status.IN_PROGRESS) {
            cancelledOrder.setStatus(Status.CANCELLED);
            // retornando pro usuario
            cancelledOrder.add(linkTo(methodOn(OrderControllerHateoas.class).cancelOrderById(id)).withSelfRel());
            cancelledOrder.add(linkTo(methodOn(OrderControllerHateoas.class).consultOrderAll()).withRel("Lista de ordem completa"));
            // salvando o repositorio
            repositoryOrder.save(cancelledOrder);
            return new ResponseEntity<>(cancelledOrder, HttpStatus.OK);

        }
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE,MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body("você não pode completar a tarefa, o pedido tem um" + cancelledOrder.getStatus() + "status");
    }


    @PutMapping("/orders/{id}/complete")
    public ResponseEntity<?> completeOrderById(@PathVariable long id){
        OrderHateoas cancelledOrder = repositoryOrder.findById(id).orElseThrow(
                () -> new OrderNotFoundExceptionHateoas(id));
        if (cancelledOrder.getStatus() == Status.IN_PROGRESS){
            cancelledOrder.setStatus(Status.COMPLETED);
            cancelledOrder.add(linkTo(methodOn(OrderControllerHateoas.class).consultOneOrder(id)).withSelfRel());
            cancelledOrder.add(linkTo(methodOn(OrderControllerHateoas.class).consultOrderAll())
                    .withRel("Complete order list"));
            repositoryOrder.save(cancelledOrder);
            return new ResponseEntity<>(cancelledOrder,HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE,
                        MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body("You can't complete the task, the order has a " +
                        cancelledOrder.getStatus() + " status");
    }

}