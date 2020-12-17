
<template>
  <div id="planif">
    <p>Nom d'évènements : </p>
    <input type='text' id='eventName'>  
    <p> Date : </p>
    <input type='text' id='date'>  
    <p>lieux : </p>
    <input type='text' id='place'>  
    
    <p>participant : </p>
    <div class="form-group" v-for="(input,k) in inputsParticipant" :key="k">
    <input type="text" class="form-control" v-model="input.name">
    <span>
        <i class="fas fa-minus-circle" @click="removeParticipant(k)" v-show="k || ( !k && inputsParticipant.length > 1)"></i>
        <i class="fas fa-plus-circle" @click="addPartcipant(k)" v-show="k == inputsParticipant.length-1"></i>
    </span>
    </div>
    <br>
    <button v-on:click="createEvent">Valider</button>
  </div>
</template>

<script>

export default {
    name: 'Planif',
    data: ()=>{
        return {
            inputsParticipant: [ {name: ''}],
        }
    },
    methods: {
        addPartcipant(index) {
            this.inputsParticipant.push({ name: '' });
        },
        removeParticipant(index) {
            this.inputsParticipant.splice(index, 1);
        },
        createEvent(){
            var participants = '';
            this.inputsParticipant.forEach(participant => participants = participants + participant.name+',');
            participants = participants.slice(0,-1);
        }
    }
}
</script>

<style>

</style>