package com.example.demo.controllers;

import com.example.demo.services.ItemsService;
import com.example.demo.services.PedidosService;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class DemoApplicationTestsContextInitializer {
  public static void registerPedidosController(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("pedidosController", PedidosController.class)
        .instanceSupplier((instanceContext) -> {
          PedidosController bean = new PedidosController();
          instanceContext.field("pedidosService", PedidosService.class)
              .invoke(beanFactory, (attributes) -> bean.pedidosService = attributes.get(0));
                  return bean;
                }).register(beanFactory);
          }

          public static void registerItemsController(DefaultListableBeanFactory beanFactory) {
            BeanDefinitionRegistrar.of("itemsController", ItemsController.class)
                .instanceSupplier((instanceContext) -> {
                  ItemsController bean = new ItemsController();
                  instanceContext.field("itemsService", ItemsService.class)
                      .invoke(beanFactory, (attributes) -> bean.itemsService = attributes.get(0));
                          return bean;
                        }).register(beanFactory);
                  }
                }
