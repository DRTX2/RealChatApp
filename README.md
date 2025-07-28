# 🚀 **RealChatApp** - Mensajería en Tiempo Real con Spring Boot & WebSocket  

---

### **Descripción del Proyecto**  

**RealChatApp** es una aplicación de mensajería instantánea en tiempo real, similar a WhatsApp o Facebook Messenger, desarrollada con **Spring Boot** y **WebSocket/STOMP**. Permite a los usuarios enviar y recibir mensajes al instante, con soporte para chats privados, persistencia de historial y autenticación segura.  

#### **Características Principales**  
✅ **Comunicación en Tiempo Real**: Usa **WebSocket** para baja latencia.  
✅ **Chat Privado**: Mensajes directos entre usuarios (ej: `/queue/mensajes/{username}`).  
✅ **Autenticación**: Integración con **Spring Security** (JWT o básica).  
✅ **Historial de Mensajes**: Almacenamiento en **PostgreSQL/MySQL** con Spring Data JPA.  
✅ **Frontend Flexible**: Compatible con **React, Angular o Vanilla JS** (ejemplo incluido).  
✅ **Escalable**: Diseñado para integrar **Redis/RabbitMQ** como broker externo.  

#### **Tecnologías Clave**  
- **Backend**: Spring Boot, WebSocket/STOMP, Spring Security, Spring Data JPA.  
- **Frontend**: SockJS + Stomp.js (ejemplo proporcionado).  
- **Base de Datos**: PostgreSQL/MySQL.  
- **Despliegue**: Docker-ready (configuración opcional incluida).  

#### **Casos de Uso**  
- Chats uno a uno entre usuarios registrados.  
- Notificaciones instantáneas sin refrescar la página.  
- Base para extenderse a grupos o videollamadas (con WebRTC).  

---

```markdown
## 📌 Ejemplo Rápido  
1. **Envía un mensaje** (vía WebSocket):  
```javascript
stompClient.send("/app/chat", {}, JSON.stringify({
    remitente: "usuario1",
    destinatario: "usuario2",
    contenido: "¡Hola! 👋"
}));
```  

2. **Recibe mensajes** en tiempo real:  
```javascript
stompClient.subscribe('/queue/mensajes/usuario2', (mensaje) => {
    console.log("Nuevo mensaje:", JSON.parse(mensaje.body));
});
```  

---

# Real Chat Application Tasks

## Backend Development
- [x] Set up Spring Boot project structure
- [x] Configure WebSocket handler
- [x] Implement GraphQL exception handling

### Authentication & Security
- [ ] Implement user authentication
  - [ ] Create user registration endpoint
  - [ ] Add login functionality
  - [ ] Set up JWT token authentication
- [ ] Add WebSocket security configuration
- [ ] Implement user session management

### Chat Features
- [ ] Message Management
  - [ ] Create message domain model
  - [ ] Implement message persistence
  - [ ] Add message timestamps and read receipts
- [ ] Chat Rooms
  - [ ] Create chat room domain model
  - [ ] Implement room creation and management
  - [ ] Add room participants handling
- [ ] Direct Messages
  - [ ] Implement private messaging
  - [ ] Add user-to-user chat functionality

### GraphQL API
- [ ] Define GraphQL Schema
  - [ ] User type and queries/mutations
  - [ ] Message type and queries/mutations
  - [ ] Chat room type and queries/mutations
- [ ] Implement Resolvers
  - [ ] User resolver
  - [ ] Message resolver
  - [ ] Chat room resolver
- [ ] Add Subscriptions
  - [ ] New message notifications
  - [ ] Online status updates
  - [ ] Typing indicators

## Database
- [ ] Design database schema
- [ ] Set up entity relationships
- [ ] Implement repositories
- [ ] Add database migrations

## Testing
- [ ] Unit Tests
  - [ ] WebSocket handler tests
  - [ ] GraphQL resolver tests
  - [ ] Service layer tests
- [ ] Integration Tests
  - [ ] WebSocket connection tests
  - [ ] Authentication flow tests
  - [ ] Message flow tests

## Frontend Development
- [ ] Set up frontend project
- [ ] Implement UI Components
  - [ ] Login/Registration forms
  - [ ] Chat interface
  - [ ] User list
  - [ ] Room list
- [ ] Add Real-time Features
  - [ ] WebSocket connection
  - [ ] Message updates
  - [ ] Typing indicators
  - [ ] Online status
- [ ] Style and Polish
  - [ ] Responsive design
  - [ ] Theme implementation
  - [ ] Loading states
  - [ ] Error handling

## Documentation
- [ ] API documentation
- [ ] Setup instructions
- [ ] User guide
- [ ] Developer documentation

## Deployment
- [ ] Configure production environment
- [ ] Set up CI/CD pipeline
- [ ] Deploy application
- [ ] Monitor and maintain