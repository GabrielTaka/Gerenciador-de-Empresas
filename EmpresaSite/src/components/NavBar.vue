<template>
  <div>
    <v-toolbar class="background-toolbar">
      <v-toolbar-items v-if="$vuetify.breakpoint.smAndUp" class="background-brand" @click="redirectToHome()">
        <v-icon class="hamburguer" @click.stop="drawer = !drawer" v-if="pwa"> menu </v-icon>
        <v-btn text>
          <img src="https://propz.com.br/wp-content/themes/propz/Content/img/svg/propz-logo.svg" class="img-brand" />
          <v-chip color="primary" class="mt-2"> BELEZA </v-chip>
        </v-btn>
      </v-toolbar-items>

      <v-toolbar-items v-if="!$vuetify.breakpoint.smAndUp" class="background-brand">
        <v-icon class="hamburguer" @click.stop="drawer = !drawer" v-if="pwa"> menu </v-icon>
      </v-toolbar-items>

      <v-spacer/>
      <language-switcher class='mr-10' v-if="!mobile"/>
    </v-toolbar>

    <v-navigation-drawer v-model="drawer" fixed temporary>
      <v-list>
        <v-list-item link>
          <v-list-item-content>
            <language-switcher/>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<script>
  import LanguageSwitcher from '@/components/LanguageSwitcher.vue'

  export default {
    components: { LanguageSwitcher },

    data() {
      return {
        locale: 'pt',
        drawer: null,
        window: {
          width: 0,
          height: 0
        },
        pwa: false,
        mobile: false,

        items: [
            { title: 'Home', icon: 'dashboard' },
            { title: 'About', icon: 'question_answer' },
          ],

      }
    },

    computed: {},

    created() {
      window.addEventListener('resize', this.handleResize)
      this.handleResize();
    },

    destroyed() {
      window.removeEventListener('resize', this.handleResize)
    },

    methods: {
      handleResize() {
        this.window.width = window.innerWidth;
        this.window.height = window.innerHeight;

        if( this.window.width <= 885 ) {
          this.pwa = true;
          console.log(this.pwa)
        } else {
          this.pwa = false;
          console.log( this.pwa)
        }

        if( this.window.width < 600 ) this.mobile = true;
        else  this.mobile = false;
      },
    }
  }
</script>

<style scoped lang="scss">
  .background-toolbar {
    background-color: #ff4f04 !important;
  }

  .img-brand {
    width: 150px;
  }
</style>
