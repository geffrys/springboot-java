# Sistema de Gestión de Pedidos para una Tienda Virtual

## Descripción General

Un sistema que permita a los usuarios realizar pedidos en una tienda virtual, gestionar inventarios, procesar pagos y realizar notificaciones en tiempo real. El sistema estará compuesto por microservicios independientes que se comunicarán mediante colas de eventos y APIs REST.

## Casos de Uso

1. Registro de Usuarios
    Descripción: Los usuarios pueden registrarse proporcionando su información básica.
    Flujo:
    El usuario envía su información al servicio de autenticación.
    El servicio guarda la información en la base de datos y emite un evento USER_REGISTERED.

2. Gestión de Productos
    Descripción: Los administradores pueden agregar, actualizar y eliminar productos.
    Flujo:
    El administrador interactúa con el servicio de inventario.
    El servicio emite eventos PRODUCT_ADDED, PRODUCT_UPDATED o PRODUCT_DELETED según corresponda.

3. Creación de Pedidos
    Descripción: Los usuarios pueden realizar pedidos seleccionando productos.
    Flujo:
   - El usuario envía un pedido al servicio de pedidos.
   - El servicio de pedidos valida el inventario a través del servicio de inventario.Si hay disponibilidad, se genera un evento ORDER_CREATED y se descuenta el inventario.
   - 
4. Procesamiento de Pagos
    Descripción: Los usuarios realizan el pago de los pedidos.
    Flujo:
    El servicio de pagos recibe la solicitud.
    Se conecta a un simulador de pasarela de pagos (puede ser una integración con una API externa).
    Si el pago es exitoso, emite un evento PAYMENT_SUCCESSFUL.

5. Notificaciones
    Descripción: Los usuarios reciben notificaciones en tiempo real sobre el estado de sus pedidos.
    Flujo:
    El servicio de notificaciones escucha eventos como ORDER_CREATED, PAYMENT_SUCCESSFUL, etc.
    Envía correos electrónicos o notificaciones push al usuario.


## Arquitectura del Sistema

### Microservicios:

- Servicio de Autenticación: Gestión de usuarios y autenticación.
- Servicio de Inventario: Gestión de productos y stock.
- Servicio de Pedidos: Gestión de creación y seguimiento de pedidos.
- Servicio de Pagos: Procesamiento de pagos.
- Servicio de Notificaciones: Envío de notificaciones a los usuarios.

### Colas de Eventos:

Utilizar RabbitMQ o Kafka para manejar eventos como USER_REGISTERED, ORDER_CREATED, etc.
Bases de Datos:

### Database per Service:

Cada microservicio tendrá su propia base de datos (patrón Database per Service).
Usar PostgreSQL o MongoDB según las necesidades.

### Gateway API:

Un API Gateway para gestionar todas las solicitudes externas y enrutar a los microservicios correspondientes.
Herramientas de Observabilidad:

- Implementar Prometheus y Grafana para monitorear el sistema.
- Usar ELK Stack (Elasticsearch, Logstash, Kibana) para logs centralizados.

### Contenedores y Orquestación:

Utilizar Docker para contenerizar los microservicios.
Implementar Kubernetes para orquestación.

## Proceso de Ingeniería de Software

### Recolección de Requisitos:

- Detallar cada caso de uso y sus requisitos funcionales y no funcionales.

### Diseño:

- Diseñar diagramas de arquitectura, flujo de datos y modelos de dominio.
Desarrollo:
    Usar Spring Boot para los microservicios.
    Implementar Spring Cloud para la comunicación entre servicios.

### Pruebas:

- Pruebas unitarias con JUnit.
- Pruebas de integración con Testcontainers.

### Despliegue:

- Configurar un pipeline de CI/CD con Jenkins o GitHub Actions.
- Desplegar en un entorno cloud (AWS, GCP o Azure)