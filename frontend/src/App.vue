<template>
    <router-view/>
</template>

<script>
export default {
  created: async function () {
    const response = await fetch('/groups')
    this.$store.state.groups = await response.json()
    const res = await fetch('/assignments')
    this.$store.state.assignments = await res.json()
  }
}
</script>

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Gemunu+Libre:wght@300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Koh+Santepheap:wght@100&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Oswald:wght@300&display=swap');

a {
  text-decoration: none;
  color: white;
}

body {
  background: url('./assets/images/clock-sand.jpg') no-repeat;
  background-size: cover;
}
</style>
