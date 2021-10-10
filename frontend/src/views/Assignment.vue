<template>
  <div>
    <v-app-bar class="main-app-bar">
      <router-link to="/">
        <v-tab class="main-logo">InnoDeadlines</v-tab>
      </router-link>
      <v-spacer></v-spacer>
      <router-link to="/add" style="color: black " v-show="this.$store.state.role === 'admin'">
        <v-tab>Add</v-tab>
      </router-link>
      <v-tab @click="logout">Logout</v-tab>
    </v-app-bar>
    <div class="options-list">
      <div class="options-name">Subject</div>
      <div class="options-text">{{ this.$store.state.currentElement.subject }}</div>
      <div class="options-name">Assignment</div>
      <div class="options-text">{{ this.$store.state.currentElement.name }}</div>
      <div class="options-name">Link</div>
      <div class="options-text"><a id="a" class="options-link">Moodle</a></div>
      <div class="options-name">Group</div>
      <div class="options-text">{{ this.$store.state.currentElement.group }}</div>
    </div>
    <div class="comments-container">
      <div class="comments-list">
        <div class="comments-item" v-for="msg in newMessages" :key="msg">{{ msg }}</div>
      </div>
      <div class="submit-container" v-show="this.$store.state.role === 'admin'">
        <textarea v-model="message" placeholder="Enter the message" id="text"></textarea>
        <button class="submit-button" @click="submitMessage">Send</button>
      </div>
    </div>
  </div>
</template>

<script>
import { logoout } from '../auth/auth'

export default {
  data: () => ({
    message: ''
  }),
  methods: {
    submitMessage: async function () {
      const response = await fetch('/comment', {
        method: 'POST',
        body: {
          message: this.message,
          id: this.$store.state.currentElement.id
        }
      })
      response.json()
      this.$store.state.currentElement.comments.push(this.message)
      this.message = ''
    },
    logout: function () {
      if (logoout()) {
        this.$router.push('/signin')
      }
    }
  },
  mounted: function () {
    document.getElementById('a').href = this.$store.state.currentElement.link
  },
  computed: {
    newMessages: function () {
      return this.$store.state.currentElement.comments
    }
  }
}
</script>

<style lang="scss" scoped>
@import url('../assets/styles/navbar.scss');

.options-link {
  color: darkblue;
}

textarea {
  width: 75%;
  height: 80px;
  padding: 5px;
  vertical-align: middle;
  border: 1px solid gray;
  border-radius: 10px;
  outline: none;
}

.submit-button {
  vertical-align: middle;
  border: none;
  border-radius: 15px;
  margin-left: 60px;
  padding: 10px 25px 10px 25px;
  font-size: 24px;
  background: cornflowerblue;
  color: white;
}

.submit-button:hover {
  background: deepskyblue;
}

.options-list {
  width: 80%;
  margin: 20px auto;
  background: white;
  border-radius: 25px;
  padding: 10px 10px 20px 10px;
  text-align: center;
  box-shadow: 2px 4px 4px black;
}

.options-name {
  display: inline-block;
  width: 45%;
  margin-top: 20px;
  background: lightgreen;
  padding: 5px;
  border-radius: 5px;
}

.options-name:first-child {
  margin-top: 0;
}

.options-text {
  display: inline-block;
  width: 45%;
  margin-top: 20px;
  margin-left: 15px;
  padding: 5px;
  border-radius: 5px;
}

.options-text:first-child {
  margin-top: 0;
}

.comments-container {
  text-align: left;
  width: 80%;
  height: 700px;
  box-shadow: 2px 4px 4px black;
  margin: 20px auto;
  background: white;
  border-radius: 25px;
  padding: 20px;
}

.comments-list {
  height: 580px;
  overflow-y: auto;
}

.comments-item {
  width: 80%;
  word-wrap: break-word;
  border-radius: 15px;
  background: lightgray;
  margin-bottom: 15px;
  padding: 5px 5px 5px 10px;
}
</style>
