<template>
  <v-navigation-drawer
    relative
    permanent
    app
    clipped>
    <v-list-item>
      <v-list-item-content>
        <v-list-item-title class="title">
          Vuhe's Weibo
        </v-list-item-title>
        <v-list-item-subtitle>
          这是一个属于社恐的个人微博
        </v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>

    <v-divider></v-divider>

    <v-list shaped>
      <v-list-item-group>
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
      </v-list-item-group>
    </v-list>
    <v-col
      class="text-center"
      cols="12"
      style="position: absolute; bottom: 0;color: hsla(0,0%,100%,.7);"
    >
      <a style="color: hsla(0,0%,100%,.7);" href="http://beian.miit.gov.cn/" target="_blank">
        豫ICP备19043858号
      </a>
      <br>
      版权所有 © {{ copy_year }}
    </v-col>
  </v-navigation-drawer>
</template>

<script>
export default {
  name: 'Navigation',
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
  }
}
</script>

<style scoped>

</style>
