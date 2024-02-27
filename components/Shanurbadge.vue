<template>
    <div :class="`shanur-badge ${type}-badge`">
        <p>
            {{ text }}
        </p>
    </div>
</template>

<script lang="ts" setup >
    interface badgeProps {
        text : String
        type : String
    }

    const props = defineProps<badgeProps>()

    const text = toRef(props,'text')
    const type = toRef(props, "type")
</script>

<style>
    .shanur-badge {
        width : 170px;
        height: 30px;
        /* top: 18px;
        left: 30px; */
        border-radius: 4px;
        border: 2px;
        gap: 10px;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .success-badge{
        background-color: #DBEBD7;
        color: #366D25;
    }

    .failed-badge {
        background-color: #FAD9D1;
        color: #82240D;
    }

    .warning-badge {
        background-color: #FEEEC1;
        color: #8F701C;

    }

</style>