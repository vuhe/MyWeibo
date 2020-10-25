<template>
  <v-app-bar
    app
    color="white"
    flat
  >
    <v-container class="py-0 fill-height">
      <v-avatar
        class="mr-10"
        color="grey darken-1"
        size="32"
      >
        <img
          src="https://oss.zhuhe.site/weibo/avatar.png"
          alt="John"
        >
      </v-avatar>

      <v-btn
        href="https://weibo.zhuhe.site/manage"
        target="_blank"
        text
      >
        管理微博
      </v-btn>

      <v-spacer></v-spacer>

      <v-responsive max-width="260">
<!--        <v-text-field-->
<!--          dense-->
<!--          flat-->
<!--          hide-details-->
<!--          rounded-->
<!--          solo-inverted-->
<!--        ></v-text-field>-->
      </v-responsive>
    </v-container>
  </v-app-bar>
</template>

<script>
export default {
  name: 'Header'
}
</script>

<style scoped>
</style>
