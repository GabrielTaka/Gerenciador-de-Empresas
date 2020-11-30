<template>
  <div class="relative">
    <v-menu top class="mr-10" >
      <template v-slot:activator="{ on, attrs }">
        <v-btn icon dark v-bind="attrs" v-on="on">
          {{ $t('select') }} <img height="25" :src="`/images/${$i18n.locale}.svg`" alt="flag" class="w-8 h-8 ml-2">
        </v-btn>
      </template>

      <v-list>
        <v-list-item @click="setLocale('pt')">
          <v-list-item-title>
            <img height="25" :src="`/images/pt.svg`" alt="flag" class="w-8 h-8"> Português
          </v-list-item-title>
        </v-list-item>

        <v-list-item @click="setLocale('en')">
          <v-list-item-title>
            <img height="25" :src="`/images/en.svg`" alt="flag" class="w-8 h-8"> English
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>

<script>

  export default {
    data() {
      return {

      }
    },
    methods: {
      setLocale(locale) {
        this.$i18n.locale = locale
        localStorage.setItem( 'locale', locale )
      }
    }
  }
</script>

<style scoped>

</style>