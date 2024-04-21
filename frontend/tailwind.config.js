/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      fontFamily:{
        bebasNeue: ['Bebas Neue', 'sans-serif'],
      },
      colors:{
        primary: '#0f172a',
        secondary:'#1e293b',
        contrast:'#ffe815'
    },
  },
  plugins: [],
}
}

