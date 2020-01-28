<template>
   <img class="imagem-responsiva" :src="src" :alt="titulo" />
</template>

<script>
export default {
  props: ['src', 'titulo']
}
</script>

<style>
  .imagem-responsiva {
    width: 100%;
  }
</style>