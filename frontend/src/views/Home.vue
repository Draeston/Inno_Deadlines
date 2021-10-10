<template>
  <div>
    <v-app-bar class="main-app-bar">
      <router-link to="/">
        <v-tab class="main-logo">InnoDeadlines</v-tab>
      </router-link>
      <v-spacer></v-spacer>
      <vSelect :options="items" :clearable="false" v-model="group" style="min-width: 150px"></vSelect>
      <router-link to="/add" style="color: black"><v-tab>Add</v-tab></router-link>
      <v-tab>Logout</v-tab>
    </v-app-bar>
    <div class="main-container">
        <router-link to="/assignment/1" tag="div" class="assignment-item">
          <h1>Title</h1>
          <img src="../assets/images/sample.jpg" alt="img">
          <p class="assignment-deadline">19 December 2021</p>
      </router-link>
      <div class="assignment-item">
        <h1>Title</h1>
        <img src="../assets/images/sample.jpg" alt="img">
        <p class="assignment-deadline">19 December 2021</p>
      </div>
      <div class="assignment-item">
        <h1>Title</h1>
        <img src="../assets/images/sample.jpg" alt="img">
        <p class="assignment-deadline">19 December 2021</p>
      </div>
      <div class="assignment-item">
        <h1>Title</h1>
        <img src="../assets/images/sample.jpg" alt="img">
        <p class="assignment-deadline">19 December 2021</p>
      </div>
    </div>
  </div>
</template>

<script>
import vSelect from 'vue-select'

export default {
  data: () => ({
    items: ['Foo', 'Bar', 'Fizz', 'Buzz', 'SD-02_b19_LMAO'],
    group: 'Foo'
  }),
  components: {
    vSelect
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
