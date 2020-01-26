<template>
  <div class="corpo">
    <h1 class="titulo">{{ name }}</h1>
    <ul class="lista-fotos">
      <li class="lista-fotos-item" v-for="foto of fotos" :key="foto.titulo">
        <meu-painel :titulo="foto.titulo">
          <img class="imagem-responsiva" :src="foto.url" :alt="foto.titulo" />
        </meu-painel>
      </li>
    </ul>
  </div>
</template>

<script>
import Painel from "./components/shared/Painel";

export default {
  name: "app",
  components: {
    "meu-painel": Painel
  },
  data() {
    return {
      name: "Projeto AluraPicure",
      fotos: []
    };
  },
  created() {
    this.$http
      .get("http://localhost:3000/v1/fotos")
      .then(res => res.json())
      .then(
        res => (this.fotos = res),
        err => console.log(err)
      );
  }
};
</script>

<style>

  .titulo {
    text-align: center;
  }

  .corpo {
    font-family: Helvetica, sans-serif;
    margin: 0 auto;
    width: 96%;
  }

  .lista-fotos {
    list-style: none;
  }

  .lista-fotos .lista-fotos-item {
    display: inline-block;
  }

  .imagem-responsiva {
    width: 100%;
  }

</style>
