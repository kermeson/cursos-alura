<template>
  <div>
    <h1 class="titulo">{{ name }}</h1>
    <input type="search" placeholder="pesquise pelo título da foto" class="filtro"
    @input="filtro = $event.target.value" />

    <ul class="lista-fotos">
      <li class="lista-fotos-item" v-for="foto of fotosFiltradas" :key="foto.titulo">
        <meu-painel :titulo="foto.titulo">
         <minha-imagem :src="foto.url" :titulo="foto.titulo" ></minha-imagem>
        </meu-painel>
      </li>
    </ul>
  </div>
</template>

<script>
import Painel from "./shared/Painel";
import ImagemResponsiva from "./shared/ImagemResponsiva"

export default {
  name: "app",
  components: {
    "meu-painel": Painel,
    "minha-imagem": ImagemResponsiva
  },
  data() {
    return {
      name: "Projeto AluraPicure",
      fotos: [],
      filtro: ''
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
  },
  computed: {
    fotosFiltradas() {
      if (this.filtro) {
        let exp = new RegExp(this.filtro.trim(), 'i');
        return this.fotos.filter(foto => exp.test(foto.titulo));
      } else {
        return this.fotos;
      }
    }

  }
};
</script>

<style>

  .titulo {
    text-align: center;
  }

  .lista-fotos {
    list-style: none;
  }

  .lista-fotos .lista-fotos-item {
    display: inline-block;
  }

  .filtro {
    width: 100%;
    height: 1.4em;
  }

</style>
