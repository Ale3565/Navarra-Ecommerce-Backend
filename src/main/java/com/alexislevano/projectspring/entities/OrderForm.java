package com.alexislevano.projectspring.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class OrderForm {
    private Client client=new Client();
    private List<OrderProduct> products=new ArrayList<>();
}
