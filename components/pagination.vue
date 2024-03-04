<template>
  <nav aria-label="Page navigation">
    <ul class="pagination">
      <li 
      style="cursor: pointer"
      :class=" `${page === 1 ? 'disabled' : ''}`"
      @click="() => handleClick(Number(page))"
      >
        <a aria-label="Previous">
          <span aria-hidden="true">«</span>
        </a>
      </li>
      <li
        style="cursor: pointer"
        v-for="index in totalPages"
        :key="index"
        :class="`${Number(index) === page ? 'active' : ''} `"
        @click="emits('handleChangePage', index)"
      >
        <a>{{ index }}</a>
      </li>
      <li
        :class=" `${page === totalPages ? 'disabled' : ''}`"
        style="cursor: pointer"
        @click="() => handleClick(Number(page))"
      >
        <a aria-label="Next">
          <span aria-hidden="true">»</span>
        </a>
      </li>
    </ul>
  </nav>
</template>

<script lang="ts" setup>
interface PaginationProps {
  page: Number;
  size: Number;
  totalPages: Number;
}

const props = withDefaults(defineProps<PaginationProps>(), {
  page: 1,
  size: 10,
  totalPages: 1,
});

const emits = defineEmits<{
  (e: "handleChangePage", payload: any): void;
}>();

const handleClick = (page:number) => {
  if (page <= Number(totalPages)) {
    emits('handleChangePage', page + 1)
  }
}

const page = toRef(props, "page");
const size = toRef(props, "size");
const totalPages = toRef(props, "totalPages");
</script>
