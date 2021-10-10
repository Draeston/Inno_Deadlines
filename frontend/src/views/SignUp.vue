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

a {
  text-decoration: none;
}

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

.centered {
  text-align: center;
  margin-top: 10px;
}

.label-pass {
  margin-right: 20px;
}

label {
  color: gray;
  user-select: none;
}

label:hover {
  text-decoration: underline;
}
</style>
