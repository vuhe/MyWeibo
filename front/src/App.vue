<template>
  <v-app id="app">
    <Navigation></Navigation>
    <Header></Header>
    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import Header from '@/components/header/Header'
import Navigation from '@/components/drawer/Navigation'

export default {
  name: 'App',
  components: {
    Header,
    Navigation
  }
}
</script>

<style>
  a {
    text-decoration: none;
  }
</style>
