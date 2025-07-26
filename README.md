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
```
