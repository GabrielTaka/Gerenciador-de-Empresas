<template>
  <v-app>
    <core-app-bar v-if="logged"/>

    <v-row>
      <v-col sm="2" v-if="logged">
        <core-side-menu v-if="!onAdmin"/>
        <core-side-menu-admin v-if="onAdmin"/>
      </v-col>

      <v-col sm="10" v-if="logged">
        <core-view />
      </v-col>

    </v-row>

    <core-view v-if="!logged"/>
  </v-app>
</template>

<script>
  import { mapActions, mapState } from 'vuex'

  export default {
    components: {
      CoreSideMenu: () => import('@/components/core/SideMenu'),
      CoreSideMenuAdmin: () => import('@/components/core/SideMenuAdmin'),
      CoreAppBar: () => import('@/components/core/AppBar'),
      CoreView: () => import('@/components/core/View'),
      DefaultAppBar: () => import('@/components/core/AppBarExternal')
    },

    computed: {
      ...mapState( ['logged', 'sideMenu'] ),

      onAdmin () {
        return this.$store.state.app.sideMenu
      }
    },


    data() {
      return {
      }
    },

    mounted() {
      if ( localStorage.getItem( 'logged' ) ) {
        this.getUserAndRedirect()

      } else {
        this.$router.push('/')
      }
    },

    methods: {
      ...mapActions([ 'getCurrentUser' ]),

      async getUserAndRedirect() {
        await this.getCurrentUser()

        if ( this.logged ) {
          this.$router.push('/dashboard')

        } else {
          this.$router.push('/')
        }
      }
    }
  }
</script>


<style>
  .dark--text {
    color: #424949 !important;
  }

  .dark--information--text {
    color: #8e8e8e !important;
  }

  .blue--text {
    color: #008BFF !important;
  }

</style>