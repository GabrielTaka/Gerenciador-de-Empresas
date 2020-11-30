<template>
  <v-app id="app">
    <nav-bar />

    <router-view class="height-body"> </router-view>

  </v-app>
</template>

<script>
  import NavBar from '../components/NavBar';


  export default {
    components: {
      NavBar
    },

    data() {
      return {
      }
    },
    computed: {},
  }
</script>

<style scoped>

  .height-body {
    height: 100%;
  }
</style>
