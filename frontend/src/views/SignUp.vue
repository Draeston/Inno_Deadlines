<template>
  <div class="login-container">
    <h1>Sign Up</h1>
    <form @submit.prevent="clickSignUp">
      <input type="text" placeholder="E-mail" v-model="email">
      <input type="password" placeholder="Password" v-model="pass">
      <input type="password" placeholder="Repeat password" v-model="repeatPass">
      <div class="centered">
        <label class="label-pass">Forgot password?</label>
        <router-link to="/"><label class="label-sign">Sign In</label></router-link>
      </div>
      <input type="submit" value="Sign Up">
    </form>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      email: '',
      pass: '',
      repeatPass: '',
      name: ''
    }
  },
  methods: {
    clickSignUp: function () {
      if (this.pass === this.repeatPass && this.pass.length >= 8) this.$router.push('/')
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
