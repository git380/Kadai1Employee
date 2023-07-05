<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebSocketチャット</title>
</head>
<body>
<input type="hidden" id="idInput" value="${role}:${name}">
<button id="joinButton">参加</button>
<br>
<textarea id="chatArea" rows="10" cols="50" readonly></textarea>
<br>
<input type="text" id="messageInput" placeholder="メッセージ">
<button id="sendButton">送信</button>

<script>
    const idInput = document.getElementById('idInput');
    const joinButton = document.getElementById('joinButton');
    const chatArea = document.getElementById('chatArea');
    const messageInput = document.getElementById('messageInput');
    const sendButton = document.getElementById('sendButton');

    const webSocket = new WebSocket('ws://192.168.137.1:8765/');

    joinButton.addEventListener('click', () => {
        const clientId = idInput.value;
        webSocket.send(clientId);
        idInput.disabled = true;
        joinButton.disabled = true;
    });

    sendButton.addEventListener('click', () => {
        const message = messageInput.value;
        webSocket.send(message);
        messageInput.value = '';
    });

    webSocket.addEventListener('message', (event) => {
        const message = event.data;
        chatArea.value += message + '\n';
    });
</script>
</body>
</html>
