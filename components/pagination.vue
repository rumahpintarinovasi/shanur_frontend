<template>
  <nav aria-label="Page navigation">
    <ul class="pagination">
      <li class="disabled">
        <a aria-label="Previous">
          <span aria-hidden="true">«</span>
        </a>
      </li>
      <li
        v-for="index in totalPages"
        :key="index"
        :class="`${Number(index) === page ? 'active' : ''} `"
        @click="emits('handleChangePage', index)"
      >
        <a>{{ index }}</a>
      </li>
      <li>
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

const page = toRef(props, "page");
const size = toRef(props, "size");
const totalPages = toRef(props, "totalPages");
</script>
