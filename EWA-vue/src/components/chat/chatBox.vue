<template>
  <div class="chat-screen">
    <div class="chat-messages">
      <div v-for="message in messages" :key="message.id" class="message">
        <span>
          {{ message }}
        </span>
      </div>
    </div>
    <div class="chat-input">
      <input v-model="userInput" v-on:keyup.enter="onNewMessage" type="text" placeholder="Type a message..."/>
      <button @click="onNewMessage">Send</button>
    </div>
  </div>
</template>

<script>
import {AnnouncementAdaptor} from "@/adaptors/AnnouncementAdapter.js";

export default {
  name: "chatBox",
  data() {
    return {
      messages: [],
      userInput: ""
    };
  },
  created() {
    // setup a new service with a web socket
    this.announcementsService = new AnnouncementAdaptor("http://localhost:8081/announcements", this.onReceiveMessage)
  },
  beforeUnmount() {
    // close down the service with the web socket
    this.announcementsService.close();
  },


  methods: {
    onReceiveMessage(message) {
      this.messages.push(message)
    },
    onNewMessage() {
      // this method is called when enter is pressed within the input text field
      // for demo purpose of a simple web socket
      this.announcementsService.sendMessage(this.userInput);
      // a persistent announcement system would save the announcement here via the REST api
      // and let the rest controller issue the websocket notification to inform all clients about the update
      this.userInput = '';
    }
  }
};
</script>

<style scoped>
.chat-screen {
  width: 400px;
  margin: 0 auto;
  background-color: #f1f1f1;
  padding: 20px;
  border-radius: 4px;
}

.chat-messages {
  max-height: 300px;
  overflow-y: scroll;
}

.message {
  margin-bottom: 10px;
  padding: 5px;
  border-radius: 4px;
}

.user-message {
  background-color: #3772ff;
  color: #fff;
}

.bot-message {
  background-color: #e8e8e8;
}

.chat-input {
  margin-top: 10px;
}

input[type="text"] {
  width: 80%;
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