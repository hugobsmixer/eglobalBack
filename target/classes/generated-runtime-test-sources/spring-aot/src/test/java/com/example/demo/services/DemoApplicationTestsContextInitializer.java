package com.example.demo.services;

import com.example.demo.repositories.ItemsRepository;
import com.example.demo.repositories.PedidosRepository;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class DemoApplicationTestsContextInitializer {
  public static void registerItemsService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("itemsService", ItemsService.class)
        .instanceSupplier((instanceContext) -> {
          ItemsService bean = new ItemsService();
          instanceContext.field("itemsRepository", ItemsRepository.class)
              .invoke(beanFactory, (attributes) -> bean.itemsRepository = attributes.get(0));
                  return bean;
                }).register(beanFactory);
          }

          public static void registerPedidosService(DefaultListableBeanFactory beanFactory) {
            BeanDefinitionRegistrar.of("pedidosService", PedidosService.class)
                .instanceSupplier((instanceContext) -> {
                  PedidosService bean = new PedidosService();
                  instanceContext.field("pedidosRepository", PedidosRepository.class)
                      .invoke(beanFactory, (attributes) -> bean.pedidosRepository = attributes.get(0));
                          return bean;
                        }).register(beanFactory);
                  }
                }
