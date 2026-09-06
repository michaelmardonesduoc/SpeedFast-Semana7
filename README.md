# SpeedFast

Actividad de Programación Orientada a Objetos 2.

## De qué se trata

Es un sistema de reparto para una empresa que se llama SpeedFast.
El programa gestiona distintos tipos de pedidos, calcula su tiempo
de entrega y permite despachar, cancelar y ver el historial.

En esta actividad practico las clases abstractas, el polimorfismo
y las interfaces.

## Clases del proyecto

- **Pedido**: clase abstracta con los datos comunes del pedido.
- **PedidoComida**: 15 min + 2 min por km.
- **PedidoEncomienda**: 20 min + 1.5 min por km.
- **PedidoExpress**: 10 min base, si es mayor a 5 km suma 5 min.
- **ControladorDeEnvios**: gestiona el despacho, la cancelación y el historial.
- **Main**: clase con el main que prueba todo.

## Interfaces

- **Despachable**: método despachar().
- **Cancelable**: método cancelar().
- **Rastreable**: método verHistorial().

## Cómo funciona

Cada tipo de pedido tiene su propia forma de asignar el repartidor
(sobrescritura) y de calcular el tiempo de entrega. El controlador
implementa las tres interfaces y guarda las entregas en un ArrayList.

En el Main creo pedidos de cada tipo, les asigno repartidor, calculo
su tiempo, los despacho o cancelo, y al final muestro el historial.

## Hecho por

Michael Mardones - DUOC UC
