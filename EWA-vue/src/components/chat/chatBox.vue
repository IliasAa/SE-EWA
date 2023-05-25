<template>
  <div class="chatbox">
    <div class="chat-messages" ref="messageContainer">
      <div v-for="message in messages" :key="message.id" class="message">
        <span style="color: #3772ff">{{ message.users.length > 0 ? message.users[0].username : 'Unknown User' }}: </span>
        <span>{{ message.message }}</span>
      </div>
    </div>
    <div class="chat-input">
      <input v-model="userInput" v-on:keyup.enter="onNewMessage" type="text" placeholder="Type a message..."/>
      <button @click="onNewMessage">Send</button>
    </div>
  </div>
</template>

<script>

export default {
  name: "chatBox",
  inject: ['notificationService','SessionService'],
  data() {
    return {
      messages: [],
      userInput: ""
    };
  },
  mounted() {
    this.scrollToBottom();
  },
  updated() {
    this.scrollToBottom();
  },
  created() {
    // setup a new service with a web socket
    // this.announcementsService = new AnnouncementAdaptor("http://localhost:8081/announcements", this.onReceiveMessage)
    this.notificationService.subscribe("chat", this.reInitialize)
    this.reInitialize();
  },

  methods: {
    onReceiveMessage(message) {
      this.messages.push(message)
    },
    onNewMessage() {

      this.$nextTick(() => {
        this.scrollToBottom();
      });

      // this method is called when enter is pressed within the input text field
      // for demo purpose of a simple web socket
      this.SessionService.sendMessage(this.userInput);

      this.userInput = "";
      // a persistent announcement system would save the announcement here via the REST api
      // and let the rest controller issue the websocket notification to inform all clients about the update
    },

    async reInitialize() {
    // reload all books from the back-end
      this.messages = (await this.SessionService.asyncFindAll());
    },

    scrollToBottom() {
      const container = this.$refs.messageContainer;
      container.scrollTop = container.scrollHeight;
    }
  },
}
</script>

<style scoped>
.chatbox {
  position: relative;
  width: 400px;
  height: 300px;
  margin: 0 auto;
  background-color: #f1f1f1;
  padding: 20px;
  border-radius: 4px;
  overflow: hidden;
}

.chat-messages {
  max-height: calc(100% - 70px); /* Adjusted to account for the chat input and close button heights */
  overflow-y: auto;
}

.message {
  margin-bottom: 10px;
  padding: 5px;
  border-radius: 4px;
}

.chat-input {
  position: absolute;
  bottom: 50px; /* Adjusted to leave space for the close button */
  left: 20px;
  right: 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

input[type="text"] {
  flex: 1;
  padding: 8px;
  border: none;
  border-radius: 4px;
}

button {
  padding: 8px 16px;
  background-color: #3772ff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}


</style>
