
<template>
  <div id="planif">
    <p>Nom d'évènements : </p>
    <input type='text' id='eventName'>  
    <p> Date : </p>
    <div class="form-group" v-for="(input,j) in inputsDate" :key="generateKey(input,j)">
    <input type="text" class="form-control" v-model="input.name">
    <span>
        <i class="fas fa-minus-circle" @click="removeDate(j)" v-show="j || ( !j && inputsDate.length > 1)"></i>
        <i class="fas fa-plus-circle" @click="addDate(j)" v-show="j == inputsDate.length-1"></i>
    </span>
    </div>

    <p>lieux : </p>
    <input type='text' id='place'>  
    
    <p>participant : </p>
    <div class="form-group" v-for="(input,k) in inputsParticipant" :key="k">
    <input type="text" class="form-control" v-model="input.name">
    <span>
        <i class="fas fa-minus-circle" @click="removeParticipant(k)" v-show="k || ( !k && inputsParticipant.length > 1)"></i>
        <i class="fas fa-plus-circle" @click="addParticipant(k)" v-show="k == inputsParticipant.length-1"></i>
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
            inputsDate: [ {name: ''}],

        }
    },
    methods: {
        addParticipant(index) {
            this.inputsParticipant.push({ name: '' });
        },
        removeParticipant(index) {
            this.inputsParticipant.splice(index, 1);
        },
        addDate(index) {
            this.inputsDate.push({ name: '' });
        },
        removeDate(index) {
            this.inputsDate.splice(index, 1);
        },
        generateKey(item,index){
            const uniqueKey = `${item}-${index}`;
            return uniqueKey;
        },
        createEvent(){
            var participants = '';
            var dates = '';
            var place = document.getElementById("place").value;
            var name = document.getElementById("eventName").value;
            this.inputsParticipant.forEach(participant => participants = participants + participant.name+',');
            participants = participants.slice(0,-1);
            this.inputsDate.forEach(date => dates = dates + date.name+',');
            dates = dates.slice(0,-1);
            
            
        },
    }
}
</script>

<style>

</style>