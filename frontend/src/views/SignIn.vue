<template>
  <div class="login-container">
    <h1>Sign In</h1>
    <form @submit.prevent="clickLogin">
      <input type="text" placeholder="E-mail" v-model="email">
      <input type="password" placeholder="Password" v-model="pass">
      <div class="centered">
        <label class="label-pass">Forgot password?</label>
        <router-link to="/signup"><label class="label-sign">Sign Up</label></router-link>
      </div>
      <input type="submit" value="Sign In">
    </form>
  </div>
</template>

<script>
import { login } from '../auth/auth'

export default {
  data: function () {
    return {
      email: '',
      pass: ''
    }
  },
  methods: {
    clickLogin: function () {
      if (login({
        email: this.email,
        password: this.pass
      })) {
        this.$store.state.isLogged = true
        this.$router.push('/')
      }
    }
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Titillium+Web:ital,wght@1,300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@200&display=swap');
@import url('../assets/styles/sign.scss');

.login-container {
  width: 40%;
  margin: 150px auto 0 auto;
  background: white;
  box-shadow: 16px 8px 20px black;
  border-radius: 20px;
  padding: 20px;
}
</style>
