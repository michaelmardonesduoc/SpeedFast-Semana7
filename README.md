# SpeedFast

Actividad de Programación Orientada a Objetos 2.

## De qué se trata

Es un sistema de reparto para una empresa que se llama SpeedFast.
El programa calcula el tiempo estimado de entrega de distintos
tipos de pedidos.

En esta actividad practico las clases abstractas y la herencia.

## Clases del proyecto

- **Pedido**: clase abstracta con los datos comunes del pedido.
- **PedidoComida**: 15 min + 2 min por km.
- **PedidoEncomienda**: 20 min + 1.5 min por km.
- **PedidoExpress**: 10 min base, si es mayor a 5 km suma 5 min.
- **Main**: clase con el main que prueba todo.

## Cómo funciona

La clase Pedido es abstracta y tiene un metodo mostrarResumen()
que muestra los datos, y un metodo abstracto calcularTiempoEntrega()
que cada subclase implementa con su propia formula.

En el Main creo un pedido de cada tipo, los guardo en un arreglo
y los recorro con un for para mostrar el resumen y el tiempo de cada uno.

## Hecho por

Michael Mardones - DUOC UC
