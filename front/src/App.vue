<template>
  <v-app id="app">
<!--    <Navigation></Navigation>-->
    <Header></Header>
    <v-content
      class="blue lighten-4">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item
                  v-for="(item, i) in items"
                  :key="i"
                  :to="item.path"
                >
                  <v-list-item-icon>
                    <v-icon v-text="item.icon"></v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title v-text="item.text"></v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  link
                  color="grey lighten-4"
                >

                  <v-list-item-content>
                    <v-list-item-title>
                      <a style="color: black;" href="http://beian.miit.gov.cn/" target="_blank">
                        豫ICP备19043858号
                      </a>
                      <br>
                      版权所有 © {{ copy_year }}
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              rounded="lg"
            >
              <router-view></router-view>
              <!--  -->
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import Header from '@/components/header/Header'
import Navigation from '@/components/drawer/Navigation'

export default {
  name: 'App',
  data () {
    return {
      items: [
        {icon: 'mdi-home', text: '主页', path: '/'},
        {icon: 'mdi-more', text: '关于', path: '/info'}
      ],
      copy_year: ''
    }
  },
  created () {
    let date = new Date()
    this.copy_year = date.getFullYear()
  },
  components: {
    Header,
    Navigation
  }
}
</script>

<style>
  body {
    background-color: #121212;
  }
  a {
    text-decoration: none;
  }
</style>
