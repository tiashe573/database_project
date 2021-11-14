var DISPLAY_IMAGE_SELECTOR = '[data-image-role="target"]';
var DISPLAY_TITLE_SELECTOR = '[data-image-role="title"]';
var DISPLAY_LINK_SELECTOR = '[data-image-role="trigger"]';

function setDetails(imageUrl, titleText){
    'use strict';

    var displayImage = document.querySelector(DISPLAY_IMAGE_SELECTOR);
    displayImage.setAttribute('src', imageUrl);

    var displayTitle = document.querySelector(DISPLAY_TITLE_SELECTOR);
    displayTitle.textContent = titleText;
}

function imageFromRoom(room){
    'use strict'
    return room.getAttribute('data-image-url');
}

function titleFromRoom(room){
    'use strict'
    return room.getAttribute('data-image-title');
}

function setDetailsFromRoom(room){
    'use strict';
    setDetails(imageFromRoom(room), titleFromRoom(room));
}

function addRoomClickHandler(room){
    'use strict'
    room.addEventListener('click', function(event){
        event.preventDefault();
        setDetailsFromRoom(room);
    });
}

function getRoomArray(){
    'use strict';
    var rooms = document.querySelectorAll(DISPLAY_LINK_SELECTOR);
    var roomArray= [].slice.call(rooms);
    return roomArray;
}

function initializeEvents(){
    'use strict'
    var rooms = getRoomArray();
    rooms.forEach(addRoomClickHandler);
}

initializeEvents();

