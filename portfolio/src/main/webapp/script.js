// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
//function addRandomGreeting() {
  //const greetings =
      //['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  //const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  //const greetingContainer = document.getElementById('greeting-container');
  //greetingContainer.innerText = greeting;}

window.addEventListener('DOMContentLoaded', event => {

    // Activate Bootstrap scrollspy on the main nav element
    const sideNav = document.body.querySelector('#sideNav');
    if (sideNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#sideNav',
            offset: 74,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});

function showTranslation() {
    const text = document.getElementById('text').value;

    const resultContainer = document.getElementById('final-text');
    resultContainer.innerText = 'Loading...';

    const params = new URLSearchParams();
    params.append('text', text);

    fetch('/translatingbox', {
        method: 'POST',
        body: params
        }).then(response => response.text())
        .then((translatedMessage) => {
        resultContainer.innerText = translatedMessage;
        });
    }
    
  

  
  
  
