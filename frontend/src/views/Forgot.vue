<template>
  <div class="login-container">
    <h1>Sign In</h1>
    <form @submit.prevent="sendEmail">
      <input type="text" placeholder="E-mail" v-show="!emailSent">
      <input type="text" placeholder="Code 4-digit" v-show="emailSent">
      <input type="submit" value="Send">
    </form>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      emailSent: false
    }
  },
  methods: {
    sendEmail: function () {
      this.$store.state.isLogged = true
      this.$router.push('/')
    }
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Titillium+Web:ital,wght@1,300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@200&display=swap');

.login-container {
  width: 40%;
  margin: 150px auto 0 auto;
  background: white;
  box-shadow: 16px 8px 20px black;
  border-radius: 20px;
  padding: 20px;
}

h1 {
  font-family: 'Yanone Kaffeesatz', sans-serif;
  font-size: 40px;
  text-align: center;
  margin-bottom: 30px;
}

input {
  display: block;
  margin: 20px auto 0 auto;
}

input[type='text'], input[type='password'] {
  border: 2px solid cornflowerblue;
  border-radius: 5px;
  padding: 2px 5px 2px 5px;
  font-family: 'Titillium Web', sans-serif;
  font-size: 24px;
  width: 60%;
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
  margin-bottom: 20px;
  cursor: pointer;
  box-shadow: 6px 3px 4px #68A1D3;
}

input[type='submit']:hover {
  background: deepskyblue;
}

a {
  text-decoration: none;
}
</style>
