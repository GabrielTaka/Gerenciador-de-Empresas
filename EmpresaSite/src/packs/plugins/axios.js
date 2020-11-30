import Vue from 'vue'
import axios from 'axios'

const API_URL = `https://5f4656bae165a60016ba9950.mockapi.io`;

const plainAxiosInstance = axios.create({
  baseURL: `${API_URL}`,
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json'
  }
})

Vue.prototype.$axios = plainAxiosInstance
export { plainAxiosInstance }
