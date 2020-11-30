<template>
  <div id="footer">
    <div class="grey-divider"></div>
    <v-container>
      <img class="mx-center image-brand" src="https://propz.com.br/wp-content/themes/propz/Content/img/svg/propz-logo.svg" />
      <p class="information-text"> 
        {{ $t('footer_message') }}
      </p>
    </v-container>
  </div>
</template>


<style scoped>
  .grey-divider {
    border-top: 2px solid rgb(201, 201, 201);
    margin-bottom: 30px;;
  }

  .mx-center {
    text-align: center;
  }

  .image-brand{
    display: block;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 50px;
    width: 10%;
  }

  @media only screen and ( max-width: 1000px ) {
    .image-brand{ 
      width: 35%;
    }
  }

  .information-text {
    text-align: justify;
    color: rgb(78, 78, 78);
  }
</style>