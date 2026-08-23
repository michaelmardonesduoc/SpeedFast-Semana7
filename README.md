# SpeedFast

Actividad de Programación Orientada a Objetos 2.

## De qué se trata

Es un sistema de reparto para una empresa que se llama SpeedFast.
El programa trabaja con distintos tipos de pedidos y le asigna un
repartidor a cada uno.

En esta actividad practico la sobrecarga y la sobreescritura de métodos.

## Clases del proyecto

- **Pedido**: clase base con los datos del pedido.
- **PedidoComida**: pedido de comida (repartidor con mochila térmica).
- **PedidoEncomienda**: pedido de encomienda (valida peso y embalaje).
- **PedidoExpress**: pedido rápido (busca el repartidor más cercano).
- **Main**: clase con el main que prueba todo.

## Cómo funciona

Cada tipo de pedido tiene su propia forma de asignar el repartidor
(sobreescritura). También hay un método que recibe el nombre del
repartidor por parámetro (sobrecarga).

En el Main creo un pedido de cada tipo, los guardo en un arreglo y
los recorro con un for para ver que cada uno responde diferente.

## Hecho por

Michael Mardones - DUOC UC
