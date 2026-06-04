"use strict";

console.log("Welcome to the Community Portal");

const sampleEventName = "Tech Workshop";
const sampleEventDate = "2026-06-15";
let sampleSeats = 24;
const sampleInfo = `${sampleEventName} is scheduled on ${sampleEventDate}. Seats: ${sampleSeats}`;
console.log(sampleInfo);

class EventItem {
  constructor(name, date, category, location, seats, fee, image) {
    this.name = name;
    this.date = date;
    this.category = category;
    this.location = location;
    this.seats = seats;
    this.fee = fee;
    this.image = image;
  }
}

EventItem.prototype.checkAvailability = function () {
  const today = new Date();
  const eventDate = new Date(this.date);
  return eventDate >= today && this.seats > 0;
};

const events = [
  new EventItem(
    "Tech Workshop",
    "2026-06-15",
    "Technology",
    "City Library",
    24,
    500,
    "Tech Workshop.jpg"
  ),
  new EventItem(
    "Music Night",
    "2026-06-18",
    "Music",
    "Town Hall",
    30,
    300,
    "Music Night.jpg"
  ),
  new EventItem(
    "Sports Tournament",
    "2026-06-20",
    "Sports",
    "Community Ground",
    18,
    400,
    "Sports Tournament.jpg"
  ),
  new EventItem(
    "Art Exhibition",
    "2026-06-22",
    "Arts",
    "Art Center",
    12,
    250,
    "Art Exhibition.jpg"
  ),
  new EventItem(
    "Community Play Day",
    "2026-06-25",
    "Community",
    "Central Park",
    40,
    200,
    "comm2.jpg"
  ),
];

events.push(
  new EventItem(
    "Coding Competition",
    "2026-06-28",
    "Technology",
    "Innovation Lab",
    16,
    350,
    "comimage1.jpg"
  )
);

function addEvent(eventList, eventItem) {
  eventList.push(eventItem);
  return eventList;
}

function createRegistrationCounter() {
  let totalRegistrations = 0;

  return function () {
    totalRegistrations++;
    return totalRegistrations;
  };
}

const countTechnologyRegistrations = createRegistrationCounter();

function filterEventsByCategory(eventList, category = "all", callback = null) {
  const clonedEvents = [...eventList];
  const filteredEvents =
    category === "all"
      ? clonedEvents
      : clonedEvents.filter((eventItem) => eventItem.category === category);

  return callback ? callback(filteredEvents) : filteredEvents;
}

function registerUser(eventName) {
  try {
    const selectedEvent = events.find((eventItem) => eventItem.name === eventName);

    if (!selectedEvent) {
      throw new Error("Event not found");
    }

    if (!selectedEvent.checkAvailability()) {
      throw new Error("Registration is closed for this event");
    }

    selectedEvent.seats--;
    sampleSeats--;

    if (selectedEvent.category === "Technology") {
      const total = countTechnologyRegistrations();
      console.log(`Technology registrations: ${total}`);
    }

    renderEvents();
    alert(`Registration successful for ${selectedEvent.name}`);
  } catch (error) {
    console.error(error.message);
    alert(error.message);
  }
}

function cancelRegistration(eventName) {
  const selectedEvent = events.find((eventItem) => eventItem.name === eventName);

  if (selectedEvent) {
    selectedEvent.seats++;
    renderEvents();
    console.log(`Cancelled registration for ${eventName}`);
  }
}

function createEventCard(eventItem) {
  const { name, date, category, location, seats, fee, image } = eventItem;
  const column = document.createElement("div");
  column.className = "col-sm-6 col-lg-4";

  const card = document.createElement("article");
  card.className = "eventCard card h-100 shadow-sm";

  card.innerHTML = `
    <div class="position-relative">
      <img src="./${image}" class="card-img-top" alt="${name}" />
      <span class="badge text-bg-danger position-absolute badge-overlay">${seats} seats</span>
    </div>
    <div class="card-body d-flex flex-column">
      <h3 class="card-title h5">${name}</h3>
      <p class="card-text mb-1">${category} event at ${location}</p>
      <p class="card-text text-muted">Date: ${date} | Fee: Rs. ${fee}</p>
      <div class="btn-group mt-auto" role="group">
        <button class="btn btn-primary register-btn" type="button">Register</button>
        <button class="btn btn-outline-danger cancel-btn" type="button">
          <i class="bi bi-x-circle"></i>
        </button>
      </div>
    </div>
  `;

  card.querySelector(".register-btn").onclick = function () {
    registerUser(name);
  };

  card.querySelector(".cancel-btn").onclick = function () {
    cancelRegistration(name);
  };

  column.appendChild(card);
  return column;
}

function renderEvents(category = "all", searchText = "") {
  const eventCards = document.querySelector("#eventCards");
  const eventInfo = document.querySelector("#eventInfo");

  if (!eventCards) {
    return;
  }

  eventCards.innerHTML = "";

  const validEvents = filterEventsByCategory(events, category, (filteredEvents) =>
    filteredEvents.filter((eventItem) => eventItem.checkAvailability())
  );

  const searchedEvents = validEvents.filter((eventItem) =>
    eventItem.name.toLowerCase().includes(searchText.toLowerCase())
  );

  const formattedNames = searchedEvents.map(
    (eventItem) => `Workshop/Event on ${eventItem.name}`
  );
  console.log(formattedNames);

  searchedEvents.forEach((eventItem) => {
    eventCards.appendChild(createEventCard(eventItem));
  });

  eventInfo.textContent = `${searchedEvents.length} valid upcoming events shown`;
  console.log(Object.entries(events[0]));
}

function enlargeImage(image) {
  image.classList.toggle("large-image");
}

function videoReady() {
  document.querySelector("#message").textContent = "Video ready to play";
  console.log("Promo video can play");
}

function findEvents() {
  const locationOutput = document.querySelector("#location");

  if (!navigator.geolocation) {
    locationOutput.textContent = "Geolocation is not supported by this browser.";
    return;
  }

  navigator.geolocation.getCurrentPosition(showLocation, showError, {
    enableHighAccuracy: true,
    timeout: 5000,
    maximumAge: 0,
  });
}

function showLocation(position) {
  document.querySelector("#location").innerHTML =
    `Latitude: ${position.coords.latitude}<br>` +
    `Longitude: ${position.coords.longitude}`;
}

function showError(error) {
  let message = "Location access denied or unavailable";

  if (error.code === error.PERMISSION_DENIED) {
    message = "Permission denied for location access";
  } else if (error.code === error.TIMEOUT) {
    message = "Location request timed out";
  }

  document.querySelector("#location").textContent = message;
}

function fetchEventsWithThen() {
  return new Promise((resolve) => {
    setTimeout(() => resolve(events), 700);
  })
    .then((mockEvents) => {
      console.log("Fetched mock events with then/catch", mockEvents.length);
      return mockEvents;
    })
    .catch((error) => console.error(error));
}

async function fetchEventsWithAsyncAwait() {
  const eventInfo = document.querySelector("#eventInfo");

  if (eventInfo) {
    eventInfo.innerHTML =
      '<span class="spinner-border spinner-border-sm"></span> Loading events...';
  }

  const mockEvents = await new Promise((resolve) => {
    setTimeout(() => resolve(events), 700);
  });

  console.log("Fetched mock events with async/await", mockEvents.length);
  renderEvents();
}

function postRegistration(userData) {
  console.log("POST payload", userData);

  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({ ok: true, message: "Registration sent to mock API" });
    }, 800);
  });
}

document.addEventListener("DOMContentLoaded", function () {
  alert("Page fully loaded");

  const categoryFilter = document.querySelector("#categoryFilter");
  const quickSearch = document.querySelector("#quickSearch");
  const musicBtn = document.querySelector("#musicBtn");

  if (categoryFilter) {
    categoryFilter.onchange = function () {
      renderEvents(categoryFilter.value, quickSearch ? quickSearch.value : "");
    };
  }

  if (quickSearch) {
    quickSearch.addEventListener("keydown", function () {
      setTimeout(() => {
        renderEvents(categoryFilter ? categoryFilter.value : "all", quickSearch.value);
      }, 0);
    });
  }

  if (musicBtn) {
    musicBtn.onclick = function () {
      renderEvents("Music");
    };
  }

  fetchEventsWithThen();
  fetchEventsWithAsyncAwait();
});

if (window.jQuery) {
  $("#musicBtn").on("click", function () {
    $("#eventCards").fadeOut(120).fadeIn(220);
  });
}

console.log("React or Vue can help by organizing larger interfaces into reusable components.");
