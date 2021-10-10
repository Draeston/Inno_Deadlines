<template>
  <div>
    <v-app-bar class="main-app-bar">
      <router-link to="/">
        <v-tab class="main-logo">InnoDeadlines</v-tab>
      </router-link>
      <v-spacer></v-spacer>
      <router-link to="/add" style="color: black"><v-tab>Add</v-tab></router-link>
      <v-tab>Logout</v-tab>
    </v-app-bar>
    <div class="options-list">
      <div class="options-name">Subject</div>
      <div class="options-text">LMAO</div>
      <div class="options-name">Assignment</div>
      <div class="options-text">Cringe</div>
      <div class="options-name">Link</div>
      <div class="options-text"><a href="" class="options-link">Moodle</a></div>
      <div class="options-name">Group</div>
      <div class="options-text">B19-SD-02</div>
    </div>
    <div class="comments-container">
      <div class="comments-list">
        <div class="comments-item" v-for="msg in newMessages" :key="msg">{{ msg }}</div>
      </div>
      <div class="submit-container">
        <textarea v-model="message" placeholder="Enter the message" id="text"></textarea>
        <button class="submit-button" @click="submitMessage">Send</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data: () => ({
    message: '',
    messages: ['Lmao', 'Cringe', 'XD', 'LMAO']
  }),
  methods: {
    submitMessage: function () {
      this.messages.push(this.message)
      this.message = ''
    }
  },
  computed: {
    newMessages: function () {
      return this.messages
    }
  }
}
</script>

<style lang="scss" scoped>
.main-app-bar {
  background: rgb(13, 156, 34);
  background: linear-gradient(90deg, rgba(13, 156, 34, 0.44947485830269607) 0%, rgba(72, 194, 118, 0.37664572665003504) 66%);
}

.main-logo {
  text-transform: none;
  font-family: 'Oswald', sans-serif;
  font-size: 44px;
  color: white;
}

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
