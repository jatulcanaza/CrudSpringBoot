/*!
 * Color mode toggler for Bootstrap's docs (https://getbootstrap.com/)
 * Copyright 2011-2024 The Bootstrap Authors
 * Licensed under the Creative Commons Attribution 3.0 Unported License.
 */
(() => {
    'use strict'
  
    // Obtiene el tema almacenado en el almacenamiento local
    const getStoredTheme = () => localStorage.getItem('theme')
    
    // Guarda el tema seleccionado en el almacenamiento local
    const setStoredTheme = theme => localStorage.setItem('theme', theme)
  
    // Devuelve el tema preferido del usuario (puede ser 'dark', 'light' o 'auto')
    const getPreferredTheme = () => {
      const storedTheme = getStoredTheme()
      if (storedTheme) {
        return storedTheme
      }
      // Si no hay tema almacenado, ajusta según la preferencia del sistema
      return window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'
    }
  
    // Aplica el tema al documento (si es 'auto', ajusta según el sistema)
    const setTheme = theme => {
      if (theme === 'auto') {
        document.documentElement.setAttribute('data-bs-theme', (window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'))
      } else {
        document.documentElement.setAttribute('data-bs-theme', theme)
      }
    }
  
    // Aplica el tema preferido al cargar la página
    setTheme(getPreferredTheme())
  
    // Muestra el tema activo y resalta el botón correspondiente
    const showActiveTheme = (theme, focus = false) => {
      const themeSwitcher = document.querySelector('#bd-theme')
  
      if (!themeSwitcher) {
        return
      }
  
      const themeSwitcherText = document.querySelector('#bd-theme-text')
      const activeThemeIcon = document.querySelector('.theme-icon-active use')
      const btnToActive = document.querySelector(`[data-bs-theme-value="${theme}"]`)
      const svgOfActiveBtn = btnToActive.querySelector('svg use').getAttribute('href')
  
      // Elimina la clase 'active' de todos los botones de selección de tema
      document.querySelectorAll('[data-bs-theme-value]').forEach(element => {
        element.classList.remove('active')
        element.setAttribute('aria-pressed', 'false')
      })
  
      // Activa el botón correspondiente al tema seleccionado
      btnToActive.classList.add('active')
      btnToActive.setAttribute('aria-pressed', 'true')
      activeThemeIcon.setAttribute('href', svgOfActiveBtn)
      
      // Actualiza la etiqueta del cambiador de tema con el tema seleccionado
      const themeSwitcherLabel = `${themeSwitcherText.textContent} (${btnToActive.dataset.bsThemeValue})`
      themeSwitcher.setAttribute('aria-label', themeSwitcherLabel)
  
      if (focus) {
        themeSwitcher.focus() // Da foco al cambiador de tema si es necesario
      }
    }
  
    // Detecta cambios en la preferencia de color del sistema (oscuro o claro)
    window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', () => {
      const storedTheme = getStoredTheme()
      if (storedTheme !== 'light' && storedTheme !== 'dark') {
        setTheme(getPreferredTheme())
      }
    })
  
    // Al cargar la página, muestra el tema activo y configura los botones para cambiar el tema
    window.addEventListener('DOMContentLoaded', () => {
      showActiveTheme(getPreferredTheme())
  
      // Configura los botones para cambiar el tema
      document.querySelectorAll('[data-bs-theme-value]')
        .forEach(toggle => {
          toggle.addEventListener('click', () => {
            const theme = toggle.getAttribute('data-bs-theme-value')
            setStoredTheme(theme)  // Guarda el tema seleccionado
            setTheme(theme)         // Aplica el tema seleccionado
            showActiveTheme(theme, true)  // Muestra el tema activo y enfoca el botón
          })
        })
    })
})()
