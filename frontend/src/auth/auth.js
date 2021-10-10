import store from '../store/index'

export async function login (credentials) {
  const response = await fetch('/login', {
    method: 'POST',
    body: JSON.stringify(credentials)
  })
  const result = await response.json()
  if (!result[1]) {
    return false
  } else {
    localStorage.setItem('authToken', result[0])
    store.state.role = result[1]
    return true
  }
}

export async function register (credentials) {
  const response = await fetch('/register', {
    method: 'POST',
    body: JSON.stringify(credentials)
  })
  return response.json()
}

export async function logoout () {
  const response = await fetch('/logout')
  localStorage.removeItem('authToken')
  return response.json()
}
