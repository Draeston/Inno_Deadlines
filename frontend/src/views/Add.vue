<template>
  <div>
    <v-app-bar class="main-app-bar">
      <router-link to="/">
        <v-tab class="main-logo">InnoDeadlines</v-tab>
      </router-link>
      <v-spacer></v-spacer>
      <v-tab @click="logout">Logout</v-tab>
    </v-app-bar>
    <div class="add-container">
      <form @submit.prevent="addAssignment">
        <input type="text" placeholder="Subject" v-model="subject">
        <input type="text" placeholder="Assignment" v-model="name">
        <input type="text" placeholder="Deadline" v-model="deadline">
        <input type="text" placeholder="Link" v-model="link">
        <vSelect :options="this.$store.state.groups" :clearable="false" v-model="group"
                 style="width: 100%; margin-top: 15px"></vSelect>
        <input type="submit" value="Add">
      </form>
    </div>
  </div>
</template>

<script>
import vSelect from 'vue-select'
import { logoout } from '../auth/auth'

export default {
  data: function () {
    return {
      link: '',
      subject: '',
      name: '',
      group: '',
      deadline: ''
    }
  },
  components: {
    vSelect
  },
  created: async function () {
    this.group = this.$store.state.groups[0]
  },
  methods: {
    addAssignment: async function () {
      const response = await fetch('/assignment', {
        method: 'POST',
        body: JSON.stringify({
          subject: this.subject,
          group: this.group,
          name: this.name,
          deadline: this.deadline,
          comments: [],
          link: this.link,
          id: 100
        })
      })
      if (response.ok) {
        this.$store.state.assignments.push({
          subject: this.subject,
          group: this.group,
          name: this.name,
          deadline: this.deadline,
          comments: [],
          link: this.link,
          id: 100
        })
        await this.$router.push('/')
      }
    },
    logout: function () {
      if (logoout()) {
        this.$router.push('/signin')
      }
    }
  }
}
</script>

<style scoped lang="scss">
@import url('../assets/styles/navbar.scss');

form {
  margin: 0 auto;
  width: 80%;
  text-align: center;
}

input[type='text'] {
  border: 2px solid cornflowerblue;
  border-radius: 5px;
  padding: 2px 5px 2px 5px;
  font-family: 'Titillium Web', sans-serif;
  font-size: 24px;
  width: 80%;
  margin: 15px auto;
}

input {
  margin-top: 20px;
}

input[type='submit'] {
  background: cornflowerblue;
  border-radius: 30px;
  color: azure;
  padding: 10px 40px 10px 40px;
  font-family: 'Titillium Web', sans-serif;
  font-style: italic;
  font-size: 26px;
  font-weight: 600;
  margin: 15px auto;
  cursor: pointer;
  box-shadow: 6px 3px 4px #68A1D3;
}

input[type='submit']:hover {
  background: deepskyblue;
}

.add-container {
  box-shadow: 16px 8px 20px black;
  border-radius: 20px;
  padding: 20px;
  width: 40%;
  background: white;
  margin: 80px auto;
}
</style>
