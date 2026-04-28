---
name: Kinetic Logic
colors:
  surface: '#16111b'
  surface-dim: '#16111b'
  surface-bright: '#3d3741'
  surface-container-lowest: '#110c15'
  surface-container-low: '#1f1a23'
  surface-container: '#231e27'
  surface-container-high: '#2e2832'
  surface-container-highest: '#39323d'
  on-surface: '#eadfed'
  on-surface-variant: '#cfc2d6'
  inverse-surface: '#eadfed'
  inverse-on-surface: '#342e38'
  outline: '#988d9f'
  outline-variant: '#4d4354'
  surface-tint: '#ddb7ff'
  primary: '#ddb7ff'
  on-primary: '#490080'
  primary-container: '#b76dff'
  on-primary-container: '#400071'
  inverse-primary: '#842bd2'
  secondary: '#4ae176'
  on-secondary: '#003915'
  secondary-container: '#00b954'
  on-secondary-container: '#004119'
  tertiary: '#adc6ff'
  on-tertiary: '#002e6a'
  tertiary-container: '#4d8eff'
  on-tertiary-container: '#00285d'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#f0dbff'
  primary-fixed-dim: '#ddb7ff'
  on-primary-fixed: '#2c0051'
  on-primary-fixed-variant: '#6900b3'
  secondary-fixed: '#6bff8f'
  secondary-fixed-dim: '#4ae176'
  on-secondary-fixed: '#002109'
  on-secondary-fixed-variant: '#005321'
  tertiary-fixed: '#d8e2ff'
  tertiary-fixed-dim: '#adc6ff'
  on-tertiary-fixed: '#001a42'
  on-tertiary-fixed-variant: '#004395'
  background: '#16111b'
  on-background: '#eadfed'
  surface-variant: '#39323d'
typography:
  h1:
    fontFamily: Space Grotesk
    fontSize: 40px
    fontWeight: '700'
    lineHeight: '1.1'
    letterSpacing: -0.02em
  h2:
    fontFamily: Space Grotesk
    fontSize: 32px
    fontWeight: '700'
    lineHeight: '1.2'
  h3:
    fontFamily: Space Grotesk
    fontSize: 24px
    fontWeight: '600'
    lineHeight: '1.2'
  body-lg:
    fontFamily: Lexend
    fontSize: 18px
    fontWeight: '400'
    lineHeight: '1.6'
  body-md:
    fontFamily: Lexend
    fontSize: 16px
    fontWeight: '400'
    lineHeight: '1.5'
  numeral-xl:
    fontFamily: Space Grotesk
    fontSize: 64px
    fontWeight: '700'
    lineHeight: '1.0'
  label-caps:
    fontFamily: Lexend
    fontSize: 12px
    fontWeight: '600'
    lineHeight: '1.0'
    letterSpacing: 0.05em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  unit: 4px
  xs: 4px
  sm: 8px
  md: 16px
  lg: 24px
  xl: 40px
  xxl: 64px
  container-padding: 20px
  gutter: 16px
---

## Brand & Style

The design system is engineered to evoke a sense of high-performance mental athletics. The brand personality is "The Professional Athlete of Academics"—focused, energetic, and precise. It targets users who view math as a skill to be mastered through repetition and speed.

The visual style blends **High-Contrast Minimalism** with **Tactile Modernism**. By utilizing a "Void" background, the interface eliminates peripheral distractions, forcing the user's focus onto the mathematical challenges. Elements feel physically present through the use of subtle gradients and thickness, creating a satisfying "press" sensation that mimics physical training equipment. The emotional response is one of clarity and momentum; every correct answer should feel like a pulse of energy.

## Colors

This design system utilizes a "Pure Dark" foundation to maximize the vibrance of functional accents. The palette is strictly utilitarian: color is never used decoratively but always to communicate state or category.

- **Backgrounds:** The primary background is a near-black gray to reduce eye strain during intense focus sessions. Surfaces use a slightly lighter value to create depth.
- **Functional Accents:** Vibrant Green, Orange, and Red indicate difficulty levels and feedback (Success/Warning/Error).
- **Engagement Colors:** Bright Blue is reserved for temporal elements (timers, progress bars), while Yellow is used exclusively for rewards and high-score achievements.
- **Primary Action:** Purple serves as the main interactive anchor, guiding users through the app flow.

## Typography

Typography in the design system prioritizes rapid scanning and mathematical clarity.

- **Space Grotesk** is used for headlines and large numeric displays. Its geometric, technical nature reinforces the "Logic" aspect of the brand.
- **Lexend** is employed for all body copy and UI labels. Originally designed to improve reading fluency, it is ideal for a training environment where speed of comprehension is vital.
- **Hierarchy:** Mathematical problems should use the `numeral-xl` style to dominate the viewport. Use `label-caps` for secondary data points like "Current Streak" or "Time Remaining" to ensure they are legible but not distracting.

## Layout & Spacing

The design system employs a **Fluid Grid** with generous safe-area margins to ensure the app feels spacious even on smaller devices.

- **The 8pt Rhythm:** All margins, paddings, and component heights follow an 8px incremental scale (derived from the 4px base unit).
- **Vertical Stack:** Training screens should center the mathematical problem vertically and horizontally, using `xxl` spacing to isolate the problem from the navigation or status bars.
- **Touch Targets:** Minimum touch target size is set to 48px, but primary interaction buttons (number pads) should aim for 64px to 80px to accommodate rapid, tactile input.

## Elevation & Depth

Depth in the design system is communicated through **Tonal Layers** and **Tactile Shadows** rather than traditional soft blurs.

- **Stacking:** The background is the lowest level (Level 0). Cards and input containers sit on Level 1 (Surface color). Active interaction elements sit on Level 2.
- **Tactile Shadows:** Buttons use a "Hard Shadow" technique—a solid, 4px offset of a darker shade of the button's own color. This creates a 3D effect that makes the button look like a physical tile.
- **Feedback Depth:** When a button is pressed, the offset shadow disappears and the element translates 2px downward, providing immediate physical feedback to the user.

## Shapes

The shape language is consistently **Rounded**, striking a balance between friendly approachability and modern precision.

- **Base Radius:** Standard UI components like cards and input fields use a 0.5rem (8px) radius.
- **Large Radius:** Primary action buttons and training tiles use a 1.5rem (24px) radius to emphasize their importance and make them feel more "clickable."
- **Consistency:** Ensure that nested elements (like a chip inside a card) have a slightly smaller radius than their container to maintain visual harmony.

## Components

- **Tactile Buttons:** These are the centerpiece. Use high-saturation colors (Purple for actions, Red/Green for choices). They must have a 4px bottom border (shadow) in a darker shade to create the "pressable" effect.
- **Statistic Cards:** Use a dark surface background with a subtle 1px border. Stats should be headlined by a large `h2` number in the `score` (Yellow) or `timer` (Blue) color.
- **Progress Bars:** Thin, high-contrast tracks. The "filled" portion should use a vibrant gradient or the `timer` blue, with a "glow" effect (subtle drop shadow of the same color).
- **Number Pad:** Large, circular or highly rounded square tiles. Use `h2` font sizes for the digits. On tap, the tile should scale down slightly (95%) to reinforce the tactile nature.
- **Difficulty Chips:** Small, pill-shaped indicators using the Easy/Intermediate/Advanced color logic. Text should be white or high-contrast black depending on the background brightness.
- **Feedback Toasts:** For "Correct" or "Incorrect" prompts, use full-width bars that slide from the top, utilizing the vibrant green or red background with bold white typography.