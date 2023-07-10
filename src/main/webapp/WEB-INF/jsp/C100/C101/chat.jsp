<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebSocketチャット</title>
    <style>
        th, td {
            width: 50%; /* セルの幅を均等に分割 */
            text-align: center; /* セルの内容を中央揃え */
        }
    </style>
</head>
<body>
<input type="hidden" id="idInput" value="${role}:${name}">
<button id="joinButton">参加</button><br>
<input type="text" id="messageInput" placeholder="メッセージ" required>
<button id="sendButton" disabled>送信</button>
<br>
<table id="chatTable">
    <tr>
        <th>source</th>
        <th>メッセージ</th>
    </tr>
</table>
<br>

<script>
    const idInput = document.getElementById('idInput');
    const joinButton = document.getElementById('joinButton');
    const chatTable = document.getElementById('chatTable');
    const messageInput = document.getElementById('messageInput');
    const sendButton = document.getElementById('sendButton');

    const webSocket = new WebSocket('ws://localhost:8765/');

    joinButton.addEventListener('click', () => {
        const clientId = idInput.value;
        webSocket.send(clientId);
        idInput.disabled = true;
        joinButton.disabled = true;
        sendButton.disabled = false; // 参加後に送信ボタンを有効にする
    });

    sendButton.addEventListener('click', () => {
        const message = messageInput.value;
        webSocket.send(message);
        messageInput.value = '';
    });

    webSocket.addEventListener('message', (event) => {
        const message = JSON.parse(event.data);

        // テーブルに行を追加
        const row = chatTable.insertRow(1);
        const cell1 = row.insertCell();
        const cell2 = row.insertCell();
        cell1.innerHTML = message.client_id;
        cell2.innerHTML = message.message;
    });
</script>
</body>
</html>