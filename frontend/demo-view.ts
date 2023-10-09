import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/text-area/src/vaadin-text-area.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/date-picker/src/vaadin-date-picker.js';
import '@vaadin/tabs/src/vaadin-tab.js';
import '@vaadin/time-picker/src/vaadin-time-picker.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('demo-view')
export class DemoView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: stretch;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);">
  <h1 style="flex-grow: 0; width: 70%; flex-shrink: 1; padding-left: var(--lumo-space-m); align-self: center;"> Termin Planner</h1>
  <vaadin-button id="all" style="align-self: center; margin-left: var(--lumo-space-xs); width: 8%;" tabindex="0">
    All Termins 
  </vaadin-button>
  <vaadin-button id="Today" style="align-self: center; margin-left: var(--lumo-space-m); width: 7%;" tabindex="0">
    Today's 
  </vaadin-button>
  <vaadin-button id="Upcoming" style="flex-grow: 0; margin-left: var(--lumo-space-l); align-self: center; width: 7%;" tabindex="0">
    Future 
  </vaadin-button>
  <vaadin-button id="filter" style="align-self: center; margin-left: var(--lumo-space-l); width: 7%;" tabindex="0">
    Filter 
  </vaadin-button>
  <vaadin-button id="login" style="align-self: center; margin-left: var(--lumo-space-l); margin-right: var(--lumo-space-s); width: 7%;" tabindex="0">
    Logout 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" style="align-items: center; flex-shrink: 0;"></vaadin-vertical-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: stretch; align-items: flex-start;">
  <vaadin-horizontal-layout theme="spacing-xl" style="justify-content: flex-start; align-items: flex-end; margin-right: var(--lumo-space-m);">
   <vaadin-date-picker label="Date of Termin" placeholder="Pick a date" id="Termin_date" style="flex-grow: 1; flex-shrink: 1; padding-left: var(--lumo-space-m);"></vaadin-date-picker>
   <vaadin-time-picker id="Termin_time" label="Tiime" placeholder="Time"></vaadin-time-picker>
  </vaadin-horizontal-layout>
  <vaadin-text-area label="Description" placeholder="Add message..." id="Text_me" style="height: 20%; width: 70%; align-self: stretch; padding-left: var(--lumo-space-m);"></vaadin-text-area>
  <vaadin-horizontal-layout>
   <vaadin-button id="Save" style="align-self: flex-start; margin: var(--lumo-space-m);" tabindex="0">
     Save 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
<vaadin-tab></vaadin-tab>
<vaadin-tab></vaadin-tab>
<vaadin-button tabindex="0">
  Button 
</vaadin-button>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
