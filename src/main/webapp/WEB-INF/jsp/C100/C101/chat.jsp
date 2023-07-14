<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WebSocketチャット</title>
    <style>
        #your_container {
            /* 高さや幅など、好きな様に設定
            bms_messages_containerの方で、縦横いっぱいに広がってくれるので、
            ここで充てた高さと横幅がそのままスタイルになる仕組み */
            height: 600px;
            width: 50%;
        }

        /* チャットの外側部分① */
        #bms_messages_container {
            /*your_containerに対して100%になる */
            height: 100%;
            width: 100%;
            background-color: #eee;
        }

        /* ヘッダー部分② */
        #bms_chat_header {
            padding: 6px; /*隙間調整*/
            font-size: 16px;
            height: 34px;
            background: #ddd;
            border: 1px solid #ccc;
        }

        /* ステータスマークとユーザー名 */
        #bms_chat_user_status {
            float: left; /* bms_chat_headerに対して左寄せ */
        }

        /* ステータスマーク */
        #bms_status_icon {
            float: left; /* bms_chat_user_statusに対して左寄せ */
            line-height: 2em; /*高さ調整*/
        }

        /* ユーザー名 */
        #bms_chat_user_name {
            float: left; /* bms_chat_user_statusに対して左寄せ */
            line-height: 2em; /*高さ調整*/
            padding-left: 8px;
        }

        /* タイムライン部分③ */
        #bms_messages {
            overflow: auto; /* スクロールを効かせつつ、メッセージがタイムラインの外に出ないようにする */
            height: 100%; /*テキストエリアが下に張り付く様にする*/
            border-right: 1px solid #ddd;
            border-left: 1px solid #ddd;
            background-color: #eee;
            box-shadow: 0px 2px 2px 0px rgba(0, 0, 0, 0.2) inset; /*ヘッダーの下に影を入れる*/
        }

        /* メッセージ全般のスタイル */
        .bms_message {
            margin: 0px;
            padding: 0 14px; /*吹き出しがタイムラインの側面にひっつかない様に隙間を開ける*/
            font-size: 16px;
            word-wrap: break-word; /* 吹き出し内で自動で改行 */
            white-space: normal; /*指定widthに合わせて、文字を自動的に改行*/
        }

        .bms_message_box {
            margin-top: 20px; /*上下の吹き出しがひっつかない様に隙間を入れる*/
            max-width: 100%; /*文字が長くなった時に吹き出しがタイムラインからはみ出さない様にする*/
            font-size: 16px;
        }

        .bms_message_content {
            padding: 20px; /*文字や画像（コンテンツ）の外側に隙間を入れる*/
        }

        /* メッセージ１（左側） */
        .bms_left {
            float: left; /*吹き出しをbms_messagesに対して左寄せ*/
            line-height: 1.3em;
        }

        .bms_left .bms_message_box {
            color: #333; /*テキストを黒にする*/
            background: #fff;
            border: 2px solid #13178E;
            border-radius: 30px 30px 30px 0px; /*左下だけ尖らせて吹き出し感を出す*/
            margin-right: 50px; /*左側の発言だとわかる様に、吹き出し右側に隙間を入れる*/
        }

        /* チャット内名前部分② */
        .bms_name_text_left {
            font-size: 6px;
            line-height: 1.3em;
        }

        /* メッセージ２（右側） */
        .bms_right {
            float: right; /*吹き出しをbms_messagesに対して右寄せ*/
            line-height: 1.3em;
        }

        .bms_right .bms_message_box {
            color: #fff; /*テキストを白にする*/
            background: #13178E;
            border: 2px solid #13178E;
            border-radius: 30px 30px 0px 30px; /*右下だけ尖らせて吹き出し感を出す*/
            margin-left: 50px; /*右側の発言だとわかる様に、吹き出し左側に隙間を入れる*/
        }

        /* チャット内名前部分② */
        .bms_name_text_right {
            float: right;
            font-size: 6px;
            line-height: 1.3em;
        }

        /* 回り込みを解除 */
        .bms_clear {
            clear: both; /* 左メッセージと右メッセージの回り込み(float)の効果の干渉を防ぐために必要（これが無いと、自分より下のメッセージにfloatが影響する） */
        }

        /* テキストエリア、送信ボタン④ */
        #bms_send {
            background-color: #eee; /*タイムラインの色と同じにする*/
            border-right: 1px solid #ddd;
            border-left: 1px solid #ddd;
            border-bottom: 1px solid #ddd;
            height: 48px;
            padding: 4px;
        }

        #bms_send_message {
            width: calc(100% - 75px); /*常に送信ボタンの横幅を引いたサイズに動的に計算*/
            line-height: 16px;
            height: 48px;
            padding: 14px 6px 0px 6px; /*文字がテキストエリアの中心になる様に隙間調整*/
            border: 1px solid #ccc;
            border-radius: 4px; /*角丸*/
            text-align: left; /*文字を左寄せ*/
            box-shadow: 2px 2px 4px 0px rgba(0, 0, 0, 0.2) inset; /*内側に影を入れてテキストエリアらしくした*/
            box-sizing: border-box; /*paddingとborderの要素の高さと幅の影響をなくす（要素に高さと幅を含める）*/

        }

        #bms_send_btn {
            width: 72px;
            height: 48px;
            font-size: 16px;
            line-height: 3em;
            float: right; /*bms_sendに対して右寄せ*/
            color: #fff;
            font-weight: bold;
            background: #bcbcbc;
            text-align: center; /*文字をボタン中央に表示*/
            border: 1px solid #bbb;
            border-radius: 4px; /*角丸*/
            box-sizing: border-box; /*paddingとborderの要素の高さと幅の影響をなくす（要素に高さと幅を含める）*/
        }

        #bms_send_btn:hover {
            background: #13178E; /*マウスポインタを当てた時にアクティブな色になる*/
            cursor: pointer; /*マウスポインタを当てた時に、カーソルが指の形になる*/
        }
    </style>
</head>
<body>
<input type="hidden" id="idInput" value="${role}:${name}">
<button id="joinButton">参加</button>
<div id="your_container">
    <!-- チャットの外側部分① -->
    <div id="bms_messages_container">
        <!-- ヘッダー部分② -->
        <div id="bms_chat_header">
            <!--ステータス-->
            <div id="bms_chat_user_status">
                <!--ステータスアイコン-->
                <div id="bms_status_icon">●</div>
                <!--ユーザー名-->
                <div id="bms_chat_user_name">病院内チャット</div>
            </div>
        </div>

        <!-- タイムライン部分③ -->
        <div id="bms_messages">
        </div>

        <!-- テキストボックス、送信ボタン④ -->
        <div id="bms_send">
            <textarea id="bms_send_message"></textarea>
            <button id="bms_send_btn" disabled>送信</button>
        </div>
    </div>
</div>

<script>
    const idInput = document.getElementById('idInput');
    const joinButton = document.getElementById('joinButton');
    const bmsMessages = document.getElementById('bms_messages');
    const bmsSendButton = document.getElementById('bms_send_btn');
    const bmsSendMessage = document.getElementById('bms_send_message');

    const webSocket = new WebSocket('ws://localhost:8765/');

    // 参加ボタン
    joinButton.addEventListener('click', () => {
        webSocket.send(idInput.value);
        idInput.disabled = true;
        joinButton.disabled = true;
        bmsSendButton.disabled = false; // 参加後に送信ボタンを有効にする
    });

    // Tabで送信
    bmsSendMessage.addEventListener('keydown', (event) => {
        if (event.key === 'Tab') {
            event.preventDefault();
            bmsSendButton.click();
        }
    });

    // 送信ボタンで文字を送る
    bmsSendButton.addEventListener('click', () => {
        const message = bmsSendMessage.value;
        webSocket.send(message);
        bmsSendMessage.value = '';
    });

    // メッセージを受信
    webSocket.addEventListener('message', (event) => {
        const message = JSON.parse(event.data);

        // メッセージを表示
        const messageContainer = document.createElement('div');
        const messageContent = document.createElement('div');
        const messageText = document.createElement('div');
        const messageName = document.createElement('div');

        messageContainer.classList.add('bms_message');
        // 追加：クライアントIDによってメッセージの位置を指定
        messageContainer.classList.add(message.client_id === idInput.value ? 'bms_right' : 'bms_left');
        messageContent.classList.add('bms_message_box');
        messageText.classList.add('bms_message_content');

        messageText.textContent = message.message;

        messageContent.appendChild(messageText);

        // 名前を表示
        if (message.client_id !== idInput.value) {
            messageName.classList.add('bms_name_text_left');
            messageName.textContent = message.client_id;
            messageContent.appendChild(messageName);
        }

        messageContainer.appendChild(messageContent);

        bmsMessages.appendChild(messageContainer);

        // bms_clear
        const clearDiv = document.createElement('div');
        clearDiv.classList.add('bms_clear');
        bmsMessages.appendChild(clearDiv);

        // スクロールを一番下に移動
        bmsMessages.scrollTop = bmsMessages.scrollHeight;
    });
</script>
</body>
</html>