<template>
  <v-content>
    <v-container
      class="fill-height"
      fluid
    >
      <v-row v-for="n in 9"
             :key="n"
             class="ml-5 mr-5 mb-5">
        <v-card
          class="mx-auto"
          color="cyan lighten-3"
          max-width="650"
        >
          <v-card-title>
            <v-icon
              large
              left
            >
              mdi-update
            </v-icon>
            <span class="title font-weight-light">{{ time }}</span>
          </v-card-title>

          <v-card-text class="headline font-weight-bold">
            {{ text }}
          </v-card-text>
        </v-card>
      </v-row>

      <v-pagination
        v-if="pageLength > 1"
        class="mt-10"
        v-model="page"
        :length="pageLength"
        next-icon=mdi-chevron-right
        prev-icon=mdi-chevron-left
        page=1
        total-visible=6
      ></v-pagination>
    </v-container>
  </v-content>
</template>

<script>
export default {
  name: 'MainContent',
  data () {
    return {
      page: 2,
      pageLength: 3,
      time: '2020-3-14 12:58',
      text: '"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as\nwell."'
    }
  }
}
</script>

<style scoped>

</style>
