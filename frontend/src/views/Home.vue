<template>
  <div>
    <v-app-bar class="main-app-bar">
      <router-link to="/">
        <v-tab class="main-logo">InnoDeadlines</v-tab>
      </router-link>
      <v-spacer></v-spacer>
      <vSelect :options="this.$store.state.groups" :clearable="false" v-model="group" style="min-width: 150px"></vSelect>
      <router-link to="/add" style="color: black" v-show="this.$store.state.role === 'admin'"><v-tab>Add</v-tab></router-link>
      <v-tab @click="logout">Logout</v-tab>
    </v-app-bar>
    <div class="main-container">
        <div @click="goTo(assign)" class="assignment-item" v-for="assign in selectedAssignment" :key="assign.name" style="text-align: left">
          <h1>{{ assign.name }}</h1>
          <img src="../assets/images/sample.jpg" alt="img">
          <p class="assignment-deadline">{{ assign.subject }}</p>
          <p class="assignment-deadline">{{ assign.deadline }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import vSelect from 'vue-select'
import { logoout } from '../auth/auth'

export default {
  data: () => ({
    group: ''
  }),
  components: {
    vSelect
  },
  created: async function () {
    this.group = this.$store.state.groups[0]
  },
  methods: {
    goTo: function (element) {
      this.$store.state.currentElement = element
      this.$router.push('/assignment')
    },
    logout: function () {
      if (logoout()) {
        this.$router.push('/signin')
      }
    }
  },
  computed: {
    selectedAssignment: function () {
      const newAssigns = []
      this.$store.state.assignments.forEach(element => {
        if (this.group === element.group) {
          newAssigns.push(element)
        }
      })
      return newAssigns
    }
  }
}
</script>

<style src="../../node_modules/vue-select/dist/vue-select.css"></style>
<style lang="scss" scoped>
@import url('../assets/styles/navbar.scss');

.main-container {
  text-align: center;
  padding-bottom: 20px;
}

.assignment-item {
  background: white;
  border-radius: 30px;
  box-shadow: 8px 4px 16px black;
  padding: 20px 15px 15px 10px;

  display: inline-block;
  width: 40%;
  text-align: left;
  margin-right: 5%;
  margin-top: 30px;
}

.assignment-item:hover {
  background: whitesmoke;
}

img {
  max-width: 100%;
  height: auto;
  border-radius: 20px;
}

h1 {
  font-family: 'Gemunu Libre', sans-serif;
  font-size: 48px;
  color: coral;
  margin-bottom: 20px;
}

p {
  font-size: 18px;
}

.assignment-deadline {
  font-family: 'Koh Santepheap', cursive;
  font-weight: 600;
  font-style: italic;
  margin-top: 15px;
}
</style>
